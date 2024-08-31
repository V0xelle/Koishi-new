/*    */ package Koishi.cards.Skills.Common;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.ForceIntentAction;
/*    */ import Koishi.cards.AbstractIntentChangingCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class Provoke extends AbstractIntentChangingCard {
/* 16 */   public static final String ID = KoishiMod.makeID(Provoke.class.getSimpleName());
/* 17 */   public static final String IMG = KoishiMod.makeCardPath("Provoke.png");
/*    */   
/* 19 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.BASIC;
/* 20 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 21 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 22 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int BLOCK = 8;
/*    */   private static final int UPGRADE_PLUS_BLOCK = 3;
/*    */   
/*    */   public Provoke() {
/* 30 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET, AbstractIntentChangingCard.IntentTypes.ATTACK);
/* 31 */     this.baseBlock = 8;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 36 */     KoishiMod.runAnimation("spellA");
/* 37 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/* 38 */     AbstractDungeon.actionManager.addToTop((AbstractGameAction)new ForceIntentAction(p, m, this.intentType));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 43 */     if (!this.upgraded) {
/* 44 */       upgradeName();
/* 45 */       upgradeBlock(3);
/* 46 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Common/Provoke.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package Koishi.cards.Skills.Common;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.ForceIntentAction;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class EmbryosDream
/*    */   extends AbstractDefaultCard {
/* 19 */   public static final String ID = KoishiMod.makeID(EmbryosDream.class.getSimpleName());
/* 20 */   public static final String IMG = KoishiMod.makeCardPath("EmbryosDream.png");
/*    */   
/* 22 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 23 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 24 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 25 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int DAMAGE = 18;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 5;
/*    */   private static final int BLOCK = 15;
/*    */   private static final int UPGRADE_PLUS_BLOCK = 5;
/*    */   
/*    */   public EmbryosDream() {
/* 36 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 37 */     this.baseDamage = 18;
/* 38 */     this.baseBlock = 15;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 43 */     KoishiMod.runAnimation("spellC");
/* 44 */     if (ForceIntentAction.attackTest.test(m)) {
/* 45 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/*    */     } else {
/* 47 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 54 */     if (!this.upgraded) {
/* 55 */       upgradeName();
/* 56 */       upgradeDamage(5);
/* 57 */       upgradeBlock(5);
/* 58 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Common/EmbryosDream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
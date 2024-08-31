/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.ForceIntentAction;
/*    */ import Koishi.cards.AbstractIntentChangingCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class EmbersOfLove
/*    */   extends AbstractIntentChangingCard {
/* 20 */   public static final String ID = KoishiMod.makeID(EmbersOfLove.class.getSimpleName());
/* 21 */   public static final String IMG = KoishiMod.makeCardPath("EmbersOfLove.png");
/*    */   
/* 23 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 24 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ALL_ENEMY;
/* 25 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 26 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   public EmbersOfLove() {
/* 31 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET, AbstractIntentChangingCard.IntentTypes.NOT_ATTACK);
/* 32 */     AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/* 33 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster mo) {
/* 38 */     KoishiMod.runAnimation("spellCall");
/* 39 */     Iterator<AbstractMonster> iterator = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/* 40 */     while (iterator.hasNext()) {
/* 41 */       AbstractMonster m = iterator.next();
/* 42 */       AbstractDungeon.actionManager.addToTop((AbstractGameAction)new ForceIntentAction(p, m, this.intentType));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void triggerWhenDrawn() {
/* 49 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DrawCardAction((AbstractCreature)AbstractDungeon.player, 1));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 54 */     if (!this.upgraded) {
/* 55 */       upgradeName();
/* 56 */       this.exhaust = false;
/* 57 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 58 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/EmbersOfLove.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
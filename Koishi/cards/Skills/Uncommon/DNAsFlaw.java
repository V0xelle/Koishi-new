/*    */ package Koishi.cards.Skills.Uncommon;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.ForceIntentAction;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.EphemeralPower;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class DNAsFlaw extends AbstractDefaultCard {
/* 17 */   public static final String ID = KoishiMod.makeID(DNAsFlaw.class.getSimpleName());
/* 18 */   public static final String IMG = KoishiMod.makeCardPath("DNAsFlaw.png");
/*    */   
/* 20 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 21 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 22 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 23 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   private static final int BUFF = 2;
/*    */   private static final int UPGRADE_PLUS_BUFF = 1;
/*    */   
/*    */   public DNAsFlaw() {
/* 31 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 32 */     this.magicNumber = this.baseMagicNumber = 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 37 */     KoishiMod.runAnimation("spellB");
/* 38 */     if (ForceIntentAction.attackTest.test(m)) {
/* 39 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new EphemeralPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 45 */     if (!this.upgraded) {
/* 46 */       upgradeName();
/* 47 */       upgradeMagicNumber(1);
/* 48 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Uncommon/DNAsFlaw.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */